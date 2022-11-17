#!/bin/sh

command_general="twine generate-all-localization-files"
command="twine generate-localization-file"
res_path="strings/strings.txt"
res_output_path="androidPhoneScreen/src/main/res/values"

declare -a platform_arguments=(
  "iosApp/iosApp/LocalizedStrings --format apple"
)

for platform in "${platform_arguments[@]}"; do
  ${command_general} ${res_path} ${platform}
done

#TODO add map path to locale
${command2} ${res_path} ${res_output_path}/generated_strings.xml --lang en --format android
${command2} ${res_path} ${res_output_path}-ru/generated_strings.xml --lang ru --format android

# cd iosApp/
# swiftgen