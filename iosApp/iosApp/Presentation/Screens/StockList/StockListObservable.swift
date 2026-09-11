//
//  StockViewModelWrapper.swift
//  iosApp
//
//  Created by NASRAT SHARIF AVEEK on 02/09/2026.
//

import Foundation
import Shared

@MainActor
final class StockListObservable: ObservableObject {
    @Published private(set) var state: StockListUiState
    
    private let viewModel : StockListViewModel
    private var observeTask: Task<Void, Never>?
    
    
    init() {
        self.viewModel = IosViewModels().stockListViewModel()
        self.state = viewModel.uiState.value
    }
    
    func activate() {
        observeTask?.cancel()
        observeTask = Task { [weak self] in
            guard let self else { return }
            for await value in self.viewModel.uiState {
                self.state = value
            }
        }
    }
    
    func deactivate() {
        observeTask?.cancel()
        observeTask = nil
    }
    
    func load () {
        viewModel.event(action: StockListActionLoadStocks.shared)
    }
    
    func refresh () {
        viewModel.event(action: StockListActionRefreshStocks.shared)
    }
}
