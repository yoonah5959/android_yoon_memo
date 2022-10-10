package heenu.moon.yoon_memo_android.presentation.ui.home

import android.icu.text.CaseMap
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import heenu.moon.yoon_memo_android.R
import heenu.moon.yoon_memo_android.presentation.theme.Yoon_memo_androidTheme
import heenu.moon.yoon_memo_android.presentation.ui.model.Memo

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
    if (covered) {
        CoveredContent()
    } else {
        MemoList(viewModel = viewModel)
    }
}

@Composable
fun MemoList(viewModel: HomeViewModel) {
    val scrollState = rememberLazyListState()
    val list = viewModel.memoList.collectAsState().value
    LazyColumn(
        modifier = Modifier.padding(top = 10.dp),
        state = scrollState
    ) {
        itemsIndexed(list, key = { index, item ->
            index
        }) { index, item ->
            MemoCell(index, item)
        }
    }
}

@Composable
fun MemoCell(index: Int, item: Memo) {
    Column(modifier =Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 20.dp)) {
//        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
//            Text(item.category, color = MaterialTheme.colors.secondary) // todo 카테고리 글자수제안도 둬야할듯
//            Text(text = item.date, color = MaterialTheme.colors.secondary)
//        }
        Text(modifier = Modifier.padding(3.dp),
            text =
        when(index){
            0 -> "MaterialTheme.typography.h1"
            1-> "MaterialTheme.typography.h2"
            2 -> "MaterialTheme.typography.h3 "
            3 -> "MaterialTheme.typography.h4"
            4 -> "MaterialTheme.typography.h5"
            5 -> "MaterialTheme.typography.h6"
            6 -> "MaterialTheme.typography.subtitle1"
            7 -> "MaterialTheme.typography.subtitle2"
            8 -> "MaterialTheme.typography.body1"
            9 -> "MaterialTheme.typography.body2"
            10 -> "MaterialTheme.typography.button"
            11 -> "MaterialTheme.typography.caption"
            else -> "MaterialTheme.typography.overline"
        }, maxLines = 1, overflow = TextOverflow.Ellipsis, style = MaterialTheme.typography.body1)
        Text(text = item.content, maxLines = 1, overflow = TextOverflow.Ellipsis, style =
            when(index){
                0 -> MaterialTheme.typography.h1
                1-> MaterialTheme.typography.h2
                2 -> MaterialTheme.typography.h3
                3 -> MaterialTheme.typography.h4
                4 -> MaterialTheme.typography.h5
                5 -> MaterialTheme.typography.h6
                6 -> MaterialTheme.typography.subtitle1
                7 -> MaterialTheme.typography.subtitle2
                8 -> MaterialTheme.typography.body1
                9 -> MaterialTheme.typography.body2
                10 -> MaterialTheme.typography.button
                11 -> MaterialTheme.typography.caption
                else -> MaterialTheme.typography.overline
            }
        )
    }
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