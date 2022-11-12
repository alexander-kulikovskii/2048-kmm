#!/bin/sh

command="twine generate-all-localization-files"
res_path="strings/strings.txt"

declare -a platform_arguments=(
  "androidPhoneScreen/src/main/res/ -r --format android"
  "iosApp/iosApp/LocalizedStrings --format apple"
)

for platform in "${platform_arguments[@]}"; do
  ${command} ${res_path} ${platform}
done

# cd iosApp/
# swiftgen