package heenu.moon.yoon_memo_android.presentation.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import heenu.moon.yoon_memo_android.R
import heenu.moon.yoon_memo_android.presentation.theme.Yoon_memo_androidTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = { HomeTopBar(viewModel) },
        content = { padding ->
            ContentNav(padding, viewModel)
        }
    )
}

@Composable
fun HomeTopBar(viewModel: HomeViewModel) {
    val covered = viewModel.homeCovered.collectAsState().value
    TopAppBar(
        title = { Text(stringResource(id = R.string.memo)) },
        backgroundColor = MaterialTheme.colors.background,
        navigationIcon = {
            IconButton(
                onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        actions = {
            Switch(checked = covered, onCheckedChange = viewModel::homeCoveredClick)
        }
    )
}

@Composable
fun ContentNav(padding: PaddingValues, viewModel: HomeViewModel) {
    val covered = viewModel.homeCovered.collectAsState().value
//    if(covered){
//
//    }
    CoveredContent()
}

@Composable
fun MemoList(viewModel: HomeViewModel) {

}

@Composable
fun CoveredContent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedButton(
            modifier = Modifier.wrapContentWidth(),
            contentPadding = PaddingValues(vertical = 12.dp, horizontal = 16.dp),
            onClick = {},
            border = BorderStroke(1.dp, MaterialTheme.colors.onBackground),
            shape = RoundedCornerShape(40.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.background,
            )
        ) {
            Icon(
                modifier = Modifier.size(16.dp, 16.dp),
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(id = R.string.add_memo)
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = stringResource(id = R.string.add_memo))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Yoon_memo_androidTheme {
        HomeScreen()
    }
}