# Gadgets Minecraft plugin


The goal is to develop a really basic plugin showing some code abilities and practices while working on a Minecraft plugin.

## Plugin Description

**The project is build on top of PaperAPI and Maven.**

The idea of this plugin is to develop one or more gadgets for in-game players to use.
The project should involve:

- [x] Command(s)
- [x] Events
- [x] Configuration File
- [x] Basic effects/particles

Examples of optional features the project could involve if putting extra time:
- [ ] Menus
- [ ] Runnables
- [ ] Animations
- [ ] NPC interactions
- [ ] More use case-related mechanics

## Testing plugin
To test the plugin:
 1. Clone the repository
 2. Build the .jar using maven
 3. Use the .jar plugin on a server

## Gadgets

### Animal canon
An item can be retrieved using `/gagets animalcanon`

When interacting with this item, it will throw a projectile spawning an animal where it hits.
The animal will be randomly picked up using probabilities from the configuration file.

-[ ] *Bonus: Integrate a reloading delay appearing to the player.*

### Monster canon
An item can be retrieved using `/gagets monstercanon`

When interacting with this item, it will throw a projectile spawning a monster where it hits.
The monster will be randomly picked up using probabilities from the configuration file.

-[ ] *Bonus: Integrate a reloading delay appearing to the player.*

### Capture canon
An item can be retrieved using `/gagets capturecanon`

When interacting with this item, it will throw a projectile capture any mob it hits.
The mob will disappear and its egg will be dropped instead.

-[ ] *Bonus: Integrate a reloading delay appearing to the player.*

