<h2>***The library contains a BroadcastReceiver to check the connectivity with internet***</h2>

<p>**Use of the library** <br>
    <b>.   Add library dependency to the app level build.gradle file.</b><br>
dependencies {<br>
    ...<br>
    implementation 'com.github.return-kr:internet_check:$_version'<br>
    ...<br>
}<br>
    <b>.   Add the following to the settings.gradle file.</b><br>
dependencyResolutionManagement {<br>
    ...<br>
    repositories {<br>
    ...<br>
    maven { url 'https://jitpack.io' }<br>
    ...<br>
    }<br>
}<br>
    <b>.   Initialize the Broadcast variable.</b><br>
    private var checkInternet: InternetCheckBroadcast ? = null<br>
    ...<br>
    ...<br>
    checkInternet = InternetCheckBroadcast()<br>
    <b>.   Set the listener to get the connectivity change callbacks.</b><br>
    ...<br>
checkInternet?.addOnInternetChangeListener(object: InternetCheckListener {<br>
    override fun onInternetActive() {<br>
        Log.d("internet_check:: ", "onInternetActive: ")<br>
        ...<br>
    }<br>
    override fun onInternetGone() {<br>
        Log.d("internet_check:: ", "onInternetGone: ")<br>
        ...<br>
    }<br>
})<br>
    <b>.   Register the broadcast.</b><br>
    ...<br>
    registerReceiver(checkInternet, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))<br>
    <b>.   Unregister the broadcast if not needed.</b><br>
    ...<br>
    unregisterReceiver(checkInternet)<br>
<br>
    ***End of Doc***<br>
</p>