
# react-native-number-picker-android

## Getting started

`$ npm install react-native-number-picker-android --save`

### Mostly automatic installation

`$ react-native link react-native-number-picker-android`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.throwjojo.numberpickerandroid.RNNumberPickerAndroidPackage;` to the imports at the top of the file
  - Add `new RNNumberPickerAndroidPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-number-picker-android'
  	project(':react-native-number-picker-android').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-number-picker-android/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-number-picker-android')
  	```


## Usage
```javascript
import RNNumberPickerAndroid from 'react-native-number-picker-android';

// TODO: What to do with the module?
RNNumberPickerAndroid;
```
  