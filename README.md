# Gadgets Minecraft plugin


The goal is to develop a really basic plugin showing code abilities and practices while working on a Minecraft plugin.

## Plugin Description

The idea of this plugin is to develop one or more gadgets for in-game players to use.
The project should involve:
- Command(s)
- Events
- Configuration File
- Sound/Particles

Optionally, the project could involve more interesting but more time-consuming things, such as (and not limited to):
Menus
- Runnables
- Animations
- NPC interactions
- More use case-related mechanics

## Gadgets

### Animal canon
An item can be retrieved using `/gagets animalcanon`

When interacting with this item, it will throw a projectile spawning an animal where it hits.
The animal will be randomly picked up using probabilities from the configuration file.

*Bonus: Integrate a reloading delay appearing to the player.*

### Monster canon
An item can be retrieved using `/gagets monstercanon`

When interacting with this item, it will throw a projectile spawning a monster where it hits.
The monster will be randomly picked up using probabilities from the configuration file.

*Bonus: Integrate a reloading delay appearing to the player.*

### Capture canon
An item can be retrieved using `/gagets capturecanon`

When interacting with this item, it will throw a projectile capture any mob it hits.
The mob will disappear and its egg will be dropped instead.

*Bonus: Integrate a reloading delay appearing to the player.*

