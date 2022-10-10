package heenu.moon.yoon_memo_android.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import heenu.moon.yoon_memo_android.R


val Pretendard = FontFamily(
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_semibold, FontWeight.SemiBold),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_regular)
)

val Head1 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Bold,
    fontSize = 96.sp,
    letterSpacing = (-1.5).sp
)

val Head2 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Bold,
    fontSize = 60.sp,
    letterSpacing = (-0.5).sp
)

val Head3 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Bold,
    fontSize = 48.sp,
    letterSpacing = 0.sp
)

val Head4 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Bold,
    fontSize = 34.sp,
    letterSpacing = 0.25.sp
)

val Head5 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    letterSpacing = 0.sp
)

val Head6 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    letterSpacing = 0.15.sp
)

/** main semi bold content style*/
val SubTitle1 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.SemiBold,
    fontSize = 18.sp,
    letterSpacing = 0.15.sp
)


val SubTitle2 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.SemiBold,
    fontSize = 24.sp,
    lineHeight = 33.6.sp,
)

/** main content text style  */
val Body1 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    letterSpacing = 0.5.sp
)


val Body2 = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    letterSpacing = 0.25.sp
)

val Button = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    letterSpacing = 1.25.sp
)

val Caption = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    letterSpacing = 0.4.sp
)

val OverLine = TextStyle(
    fontFamily = Pretendard,
    fontWeight = FontWeight.Normal,
    fontSize = 10.sp,
    letterSpacing = 1.5.sp
)

val Typography = Typography(
    h1 = Head1,
    h2 = Head2,
    h3 = Head3,
    h4 = Head4,
    h5 = Head5,
    h6 = Head6,
    subtitle1 = SubTitle1,
    subtitle2 = SubTitle2,
    body1 = Body1,
    body2 = Body2,
    button = Button,
    caption = Caption,
    overline = OverLine
)
