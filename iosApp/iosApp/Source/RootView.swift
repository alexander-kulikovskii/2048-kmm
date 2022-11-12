//
//  RootView.swift
//  iosApp
//
//  Created by Aleksandr Kulikovskiy on 2.8.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared
import sharedSwift

struct RootView : View {
    @EnvironmentObject var viewRouter: ViewRouter
    
    let observableSplashInteractor: ObservableSplashInteractor
    
    init() {
        observableSplashInteractor = ObservableSplashInteractor()
    }
    
    var body: some View {
        switch viewRouter.currentScreen {
        case ScreenKs.splash:
            SplashScreen().environmentObject(observableSplashInteractor)
        case ScreenKs.main:
            MainScreen()
        default:
            MainScreen()
        }
    }
}
