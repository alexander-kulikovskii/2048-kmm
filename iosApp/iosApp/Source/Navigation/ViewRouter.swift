//
//  ViewRouter.swift
//  iosApp
//
//  Created by Aleksandr Kulikovskiy on 1.8.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared
import sharedSwift

class ViewRouter: ObservableObject {
    
    @Published var currentScreen: ScreenKs = .splash
    
    public func setCurrentPage(command: BinumbersNavigation?){
        
        switch command{
        case is Navigation:
            let newScreen = ScreenKs.init((command as! Navigation).to as! Screen)
            self.currentScreen = newScreen
        default:
            print("oh no")
        }
    }
}
