import UIKit
import SwiftUI
import Shared
//struct ComposeView: UIViewControllerRepresentable {
////    func makeUIViewController(context: Self.Context) -> UIViewController {
//////        MainViewControllerKt.MainViewController()
////    }
//
//    func updateUIViewController(_ uiViewController: UIViewController, context: Self.Context) {}
//}

struct ContentView: View {
    @State
    private var isAnimating = false
    var body: some View {
        VStack {
            Text("Hello, World!" + Greeting().greet())
            Button("Click me!") {
                HStack{
                    Image(systemName: "star.fill")
                                        .foregroundColor(.red)
                                        .scaleEffect(isAnimating ? 2 : 1)
                }
                
            }
        }
    }
}
