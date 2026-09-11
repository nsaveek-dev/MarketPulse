import SwiftUI
import Shared

struct StockListView: View {
    @StateObject private var vm = StockListObservable()
    var body: some View {
        VStack(spacing: 0) {
            StockListHeader()
            List(vm.state.listOfStocks, id: \.name) { stock in
                StockRow(
                    symbol: stock.name,
                    price: StockFormatter.formatPrice(stock.price),
                    change: StockFormatter.formatChange(stock.change),
                    changePercent: StockFormatter.formatChangePercent(stock.changePercent),
                    changeColor: changeColor(stock.change)
                )
                .listRowInsets(EdgeInsets())
                .listRowSeparator(.hidden)
                .listRowBackground(Color.clear)
            }
            .listStyle(.plain)
            .scrollContentBackground(.hidden)
            .overlay { if vm.state.isLoading { ProgressView() } }
            .task {
                vm.activate()
            }
            .onDisappear() {
                vm.deactivate()
            }
            .refreshable { vm.refresh() }
        }
        .background(Color(.systemGroupedBackground))
    }
}
