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
        wait(10.0) {
            sendMessageToPlayers(sampleWorld.players)
        }
    }
    
    private fun sendMessageToPlayers(playerList: List<Player>) {
        playerList.forEach { 
            it.sendMessage(Component.text("Hello!"))
        }
    }
}
```