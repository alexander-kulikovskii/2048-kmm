//
//  SplashScreen.swift
//  iosApp
//
//  Created by Aleksandr Kulikovskiy on 31.7.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared
import sharedSwift

struct SplashScreen: ConnectedSplashView{
    @EnvironmentObject var splashInteractor: ObservableSplashInteractor
    
    @EnvironmentObject var viewRouter: ViewRouter
  
    struct Props {
        let loading: Bool
        let onAppear: () -> Void
    }
    
    func map(state: SplashState, dispatch: @escaping DispatchSplashFunction) -> Props {
        return Props(
            loading: state.progress,
            
            onAppear: {
                dispatch(SplashAction.Load())
            }
        )
    }
    
    func body(props: Props) -> some View {
        VStack {
            if (props.loading){
                ProgressView()
            } else {
                Text("go to main")
            }
        }
        .onAppear {
            props.onAppear()
        }
        .onReceive(splashInteractor.$navigation) { command in
            viewRouter.setCurrentPage(command: command)
        }
    }
}
