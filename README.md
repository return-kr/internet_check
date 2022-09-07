# The library contains a BroadcastReceiver to check the connectivity with Internet #
## Use of the library ##
### Add library dependency to the app level build.gradle file. ###

   ```gradle
   dependencies {
        implementation 'com.github.return-kr:$latest_version'
   }
   ```
### Add the following to the settings.gradle file. ###
```gradle
dependencyResolutionManagement {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
### Initialize the Broadcast variable. ###
```kotlin
private var checkInternet: InternetCheckBroadcast ? = null

checkInternet = InternetCheckBroadcast()
```
### Set the listener to get the connectivity change callbacks. ###
```kotlin
checkInternet?.addOnInternetChangeListener(object: InternetCheckListener {
    override fun onInternetActive() {
        Log.d("internet_check::", "onInternetActive:")
    }
    override fun onInternetGone() {
        Log.d("internet_check::", "onInternetGone:")
    }
})
```
### Register the broadcast. ###
```kotlin
registerReceiver(checkInternet, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
```
### Unregister the broadcast if not needed. ###
```kotlin
unregisterReceiver(checkInternet)
```
***End of Doc***