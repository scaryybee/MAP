# More API for Paper
- Add at Minecraft Paper API

### What can MAP help me?
- Map Can Help Your Coding.
- You can reduce time to do.
- Easy Functions!

Maven ( pom.xml )
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.AtSignRANK</groupId>
    <artifactId>MAP</artifactId>
    <version>Version</version>
</dependency>
```

Gradle Groovy DSL ( build.gradle )
```gradle
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation "com.github.AtSignRANK:MAP:Version"
}
```

Gradle Kotlin DSL ( build.gradle.kts )
```gradle
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.AtSignRANK:MAP:Version")
}
```

Sample
```kotlin
class Sample : JavaPlugin() {
    override fun onEnable() {
        val sampleWorld = addWorld(NamespacedKey("sample"))
        events {
            onPlayerJoin {
                wait(10.0) {
                    sendMessageToPlayers(sampleWorld.players)
                }
                
                loop(20L, 10) {
                    player.sendMessage(Component.text(time()))
                }
            }
            
            onPlayerDeath {
                isCancelled = true
                
                Text("${player.name} is Die!").toComponent() sendTo sampleWorld.players
            }
        }
    }
    
    private fun sendMessageToPlayers(playerList: List<Player>) {
        playerList.forEach { 
            Component.text("Hello!") sendTo it
            
            it to Location(overWorld, 0.0, 60.0, 0.0)
        }
        
        wait(40L) { Component.text("Bye!") sendTo playerList }
    }
}
```