# More API for Paper
- Add at Minecraft Paper API

## How can I use MAP?
- It's Not Completed
- Before I make release, You may use my code
- After I make release, Use just release

### What can MAP help me?
- Map Can Help Your Coding.
- You can reduce time to do.
- Easy Functions!

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