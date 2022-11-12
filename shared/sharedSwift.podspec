Pod::Spec.new do |spec|
    spec.name                     = 'sharedSwift'
    spec.version                  = '1.0'
    spec.homepage                 = 'Link to a Kotlin/Native module homepage'
    spec.source                   = { :git => "Not Published", :tag => "Cocoapods/#{spec.name}/#{spec.version}" }
    spec.authors                  = ''
    spec.license                  = ''
    spec.summary                  = 'Some description for a Kotlin/Native module'
    spec.module_name              = "sharedSwift"

    spec.static_framework         = true
    spec.dependency 'shared'
    spec.source_files = "build/cocoapods/framework/sharedSwift/**/*.{h,m,swift}"

    spec.ios.deployment_target = '14.1'
end