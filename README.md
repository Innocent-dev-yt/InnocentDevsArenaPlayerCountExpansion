# ArenaPlayerCountExpansion

**ArenaPlayerCountExpansion** is a PlaceholderAPI expansion for the Minecraft plugin **StrikePractice**. It provides a live count of players currently inside a specified arena by checking player positions within the arena’s boundary corners.

---

## Features

- Query the number of players inside a specific arena by name
- Checks all online players’ positions against arena boundaries
- Returns live, real-time player counts for arenas
- Supports dynamic placeholders compatible with PlaceholderAPI

---

## Placeholder Format

Use the following placeholder to get the player count inside an arena:
##### %arena_<arenaName>_count%


Replace `<arenaName>` with the exact name of your arena.

### Examples

| Arena Name | Placeholder               | Description                        |
|------------|---------------------------|----------------------------------|
| `main`     | `%arena_main_count%`       | Shows players inside arena "main"|
| `parkour`  | `%arena_parkour_count%`    | Shows players inside arena "parkour"|
| `spleef`   | `%arena_spleef_count%`     | Shows players inside arena "spleef"|

---

## Usage

- Add these placeholders to your scoreboard, tablist, or chat to display live player counts for each arena.
- Useful for helping players see how many others are playing in specific arenas and choose where to join.

---

## Installation

1. Download the expansion and place it in your server’s `plugins/` folder.
2. Restart the server .
3. Use the placeholders as described above in your configuration files.

---

## Support

If you encounter any issues or want to request features, please open an issue on the repository.

---

*This expansion requires PlaceholderAPI and StrikePractice plugins to be installed and running on your Minecraft server.*

