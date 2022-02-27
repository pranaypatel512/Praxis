plugins {
  id(BuildPlugins.ANDROID_LIBRARY_PLUGIN)
  id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
  id(BuildPlugins.KOTLIN_KAPT)
}

android {
  compileSdk = 31

  defaultConfig {
    minSdk = (AppVersions.MIN_SDK)
    targetSdk = (AppVersions.TARGET_SDK)
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }

  composeOptions {
    kotlinCompilerExtensionVersion = Lib.Androidx.composeVersion
  }
}

// Required for annotation processing plugins like Dagger
kapt {
  generateStubs = true
  correctErrorTypes = true
}

dependencies {
  /*Kotlin*/


  Lib.Androidx.list.forEach(::implementation)
  Lib.Androidx.Compose.list.forEach(::implementation)
  Lib.ThirdParty.list.forEach(::implementation)
  Lib.Accompanist.list.forEach(::implementation)
  Lib.Google.list.forEach(::implementation)
  Lib.Kotlin.list.forEach(::implementation)

  /*DI*/
  implementation(Lib.Di.hilt)
  implementation(Lib.Di.hiltNavigationCompose)
  implementation(Lib.Di.hiltViewModel)
  kapt(Lib.Di.hiltCompiler)
  kapt(Lib.Di.hiltAndroidCompiler)

  // Room
  implementation(Lib.Room.roomKtx)
  implementation(Lib.Room.roomRuntime)
  add("kapt", Lib.Room.roomCompiler)
  testImplementation(Lib.Room.testing)

  UnitTesting.list.forEach(::testImplementation)
  DevDependencies.debugList.forEach(::debugImplementation)
  DevDependencies.list.forEach(::implementation)
}