
# react-native-insta-capture

## Getting started

`$ npm install react-native-insta-capture --save`

### Mostly automatic installation

`$ react-native link react-native-insta-capture`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-insta-capture` and add `RNInstaCapture.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNInstaCapture.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNInstaCapturePackage;` to the imports at the top of the file
  - Add `new RNInstaCapturePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-insta-capture'
  	project(':react-native-insta-capture').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-insta-capture/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-insta-capture')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNInstaCapture.sln` in `node_modules/react-native-insta-capture/windows/RNInstaCapture.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Com.Reactlibrary.RNInstaCapture;` to the usings at the top of the file
  - Add `new RNInstaCapturePackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNInstaCapture from 'react-native-insta-capture';

// TODO: What to do with the module?
RNInstaCapture;
```
  