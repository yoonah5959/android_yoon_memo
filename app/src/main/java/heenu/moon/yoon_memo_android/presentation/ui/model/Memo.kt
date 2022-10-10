package heenu.moon.yoon_memo_android.presentation.ui.model

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.text.TextStyle
import java.util.*

data class Memo(
    val category: String = "모든앱",
    val title: String,
    val content: String,
    val date: String,// todo date 처리
)

