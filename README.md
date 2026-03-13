# Insight - Android 智能相机与题目提取

Insight 是一款基于 Android 16 (SDK 36) 开发的智能相机应用，专注于题目识别与知识图谱构建。

## 核心功能

*   **智能相机拍摄**：支持前后摄像头，具备自动对焦与高精度拍摄功能。
*   **可拖动选题框**：在录题阶段，用户可以自由拖动和调整选取框（支持四个角及四边拖动），精确选择题目区域。
*   **动态扫描效率**：内置流畅的扫描动画，提升用户交互体验。
*   **图片处理**：自动处理镜头旋转与图片格式，为后续 OCR 提供高质量图像。

## 技术栈

*   **UI 框架**：Jetpack Compose
*   **相机引擎**：CameraX
*   **依赖注入**：Hilt
*   **后端交互**：Retrofit + OkHttp (SSE)
*   **图形展示**：Vico

## 项目状态

目前已完成相机基础功能、可拖动选取框的交互逻辑、以及基础的导航系统。

## 如何运行

1. 使用 Android Studio Ladybug 或更高版本打开项目。
2. 确保安装了 Android 16 (Vanilla Ice Cream) SDK。
3. 连接物理设备或启动模拟器（推荐模拟器需支持 Camera 模拟）。
4. 在 `gradle.properties` 中确保已包含 `android.suppressUnsupportedCompileSdk=36` 以通过 SDK 版本校验。
