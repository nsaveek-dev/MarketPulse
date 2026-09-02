import UIKit
import SwiftUI
import Shared

struct StockListView: View {
    @StateObject private var vm = StockListObservable()
    private var isAnimating = false
    var body: some View {
        VStack {
            List(vm.state.listOfStocks, id: \.name) { stock in
                Text(stock.name)
            }
            .overlay { if vm.state.isLoading { ProgressView() }}
            .task {
                vm.activate()
            }
            .onDisappear() {
                vm.deactivate()
            }
            .refreshable { vm.refresh() }
        }
    }
}
