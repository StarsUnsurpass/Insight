# Changelog

All notable changes to this project will be documented in this file.

## [Unreleased] - 2026-03-13

### Added
- **MainScreen**: New root navigation container with macOS-style floating Dock.
- **Floating Dock**: Fluid navigation bar with physical spring animations and auto-hide logic on scroll.
- **Circular Reveal**: Implemented a smooth full-screen transition when opening the camera.
- **Gooey Effect**: Added visual separation logic for the central scanning button.
- **Radar Chart**: Custom Canvas implementation for ability assessment in the Dashboard.
- **Knowledge Map**: Grid-based domain visualization with progress tracking.
- **Profile Dashboard**: User statistics and settings layout.
- **OCR Toggle**: Ability to switch between image and recognized text in Solution screen.

### Changed
- **Scanner UI**: Refactored the capture engine for a more immersive, static viewfinder experience.
- **Solution UI**: Redesigned as a modular bottom sheet with structured analysis sections (Insight, Interference).
- **Dashboard UI**: Transformed the starfield into a comprehensive Learning Analytics dashboard.
- **Navigation**: Switched to a tab-based system centered around the floating Dock.

### Fixed
- Resolved `Icon` component overload resolution ambiguity by enforcing named parameters.
- Fixed missing imports for `alpha`, `ImageVector`, `Canvas`, and `LazyColumn`.
- Corrected deprecated icon references (`ArrowForward` -> `AutoMirrored.ArrowForward`).
- Suppressed Hilt/Kapt compiler warnings by aligning `arguments` in `build.gradle.kts`.
- Fixed unused parameter and variable warnings across multiple UI screens.
- Corrected `Scaffold` and `Modifier.padding` usage errors.

### Security
- Verified no sensitive keys or credentials in updated UI components.
