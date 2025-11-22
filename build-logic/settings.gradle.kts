// 独立ビルド内でも version catalog を再定義
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            // ルートの catalog を再利用（パスはプロジェクト構成に合わせて調整）
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"

