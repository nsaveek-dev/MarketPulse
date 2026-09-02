import SwiftUI
import Shared

@main
struct iOSApp: App {
    init() {
        KoinInitializer.shared.doInitKoinIos()
    }

    var body: some Scene {
        WindowGroup {
            StockListView()
        }
    }
}
