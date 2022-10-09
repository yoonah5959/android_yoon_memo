package heenu.moon.yoon_memo_android.screen

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import heenu.moon.yoon_memo_android.R
import heenu.moon.yoon_memo_android.ui.theme.Yoon_memo_androidTheme

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { HomeTopBar() }
    ) {

    }
}

@Composable
fun HomeTopBar() {
    TopAppBar(
        title = { Text(stringResource(id = R.string.memo))},
        backgroundColor = MaterialTheme.colors.background,
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        actions = {
//            RadioButton(selected = , onClick = { /*TODO*/ })
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Yoon_memo_androidTheme {
        HomeScreen()
    }
}