import SwiftUI
import shared
import Foundation

func startKoin() {
    KoinIosKt.doInitKoinIos()
}

@main
struct iOSApp: App {
    
    @StateObject var viewRouter = ViewRouter()
    
    init() {
        startKoin()
    }
    
	var body: some Scene {
		WindowGroup {
            RootView().environmentObject(viewRouter)
		}
	}
}
