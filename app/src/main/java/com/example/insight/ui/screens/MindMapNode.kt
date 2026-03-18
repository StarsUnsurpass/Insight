package com.example.insight.ui.screens

import com.google.gson.annotations.SerializedName
import java.util.UUID

data class MindMapNode(
    @SerializedName("id") val id: String = UUID.randomUUID().toString(),
    @SerializedName("title") var title: String,
    @SerializedName("nodeType") val nodeType: String = "branch", // "root", "branch", "leaf"
    @SerializedName("tags") val tags: List<String> = emptyList(),
    @SerializedName("children") var children: List<MindMapNode> = emptyList(),
    
    // UI 状态，不参与序列化
    var isExpanded: Boolean = true
)
