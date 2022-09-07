<h2>***The library contains a BroadcastReceiver to check the connectivity with internet***</h2>

**Use of the library**
    <b>.   Add library dependency to the app level build.gradle file.</b>
dependencies {
    ...
    implementation 'com.github.return-kr:internet_check:$_version'
    ...
}
    <b>.   Add the following to the settings.gradle file.</b>
dependencyResolutionManagement {
    ...
    repositories {
    ...
    maven { url 'https://jitpack.io' }
    ...
    }
}
    <b>.   Initialize the Broadcast variable.</b>
    private var checkInternet: InternetCheckBroadcast ? = null
    ...
    ...
    checkInternet = InternetCheckBroadcast()
    <b>.   Set the listener to get the connectivity change callbacks.</b>
    ...
checkInternet?.addOnInternetChangeListener(object: InternetCheckListener {
    override fun onInternetActive() {
        Log.d("internet_check:: ", "onInternetActive: ")
        ...
    }
    override fun onInternetGone() {
        Log.d("internet_check:: ", "onInternetGone: ")
        ...
    }
})
    <b>.   Register the broadcast.</b>
    ...
    registerReceiver(checkInternet, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    <b>.   Unregister the broadcast if not needed.</b>
    ...
    unregisterReceiver(checkInternet)

***End of Doc***