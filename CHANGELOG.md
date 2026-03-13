# Changelog

All notable changes to this project will be documented in this file.

## [Unreleased] - 2026-03-13

### Added
- **Theme Engine**: Comprehensive dynamic skinning with 6 preset styles (Ocean, Sunset, Sakura, etc.).
- **Z-Axis Zoom**: High-end spatial page transition for tab switching with parallax scaling.
- **Settings System**: Fully functional preference screen for username, theme, and haptic feedback.
- **Physical Dock Indicator**: Independent edge spring model for realistic "Squash & Stretch" liquid movement.
- **MainScreen Integration**: Centralized root container managing navigation state and fluid Dock behavior.

### Changed
- **Dock Refinement**: Precision pixel-perfect alignment using geometry center logic.
- **Dock Collapse**: Extreme center collapse to 72dp with a physical size-locked camera pivot.
- **Visual Standardization**: Unified primary color tokens across all screens for responsive theme support.
- **Transition Choreography**: Optimized enter/exit scales (85% to 115%) for natural spatial flow.

### Fixed
- Eliminated all Kapt unrecognized option warnings via compiler argument adjustments.
- Resolved "initial sink" animation bug in MainScreen by introducing initialization gating.
- Fixed pixel misalignment between icons and background indicators in the Dock.
- Suppressed `statusBarColor` and `LinearProgressIndicator` API deprecation warnings.
- Corrected navigation return paths to ensure `Settings` always goes back to `Profile`.

### Security
- Verified no sensitive keys or credentials in updated UI components.
