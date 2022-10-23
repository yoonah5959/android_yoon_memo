package heenu.moon.yoon_memo_android.presentation.ui.home

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
        backgroundColor = MaterialTheme.colors.background,
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
        elevation = 0.dp,
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
            Switch(
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colors.primary,
                    checkedTrackColor = MaterialTheme.colors.primary,
                    uncheckedThumbColor = MaterialTheme.colors.surface,
                    uncheckedTrackColor = MaterialTheme.colors.onSurface,
                ),
                checked = covered, onCheckedChange = viewModel::homeCoveredClick
            )
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
        state = scrollState
    ) {
        itemsIndexed(list, key = { index, item ->
            index
        }) { index, item ->
            MemoItem(item, index == list.size - 1)
        }
    }
}

@Composable
fun MemoItem(item: Memo, isEnd: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 0.dp, bottom = 12.dp, start = 24.dp, end = 24.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // category
            Text(
                item.category,
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(top = 6.dp)
            ) //todo 카테고리 글자수제안도 둬야할듯

            // date
            Text(
                text = item.date, color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.body2
            )
        }

        // title
        Text(
            modifier = Modifier.padding(bottom = 2.dp),
            text = item.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.subtitle1
        )

        // content
        Text(
            text = item.content,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colors.secondary
        )

        // divider
        if (!isEnd) {
            Divider(
                Modifier.padding(top = 12.dp),
                color = MaterialTheme.colors.onSecondary,
                thickness = 0.5.dp
            )
        }

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

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun DefaultPreview() {
    Yoon_memo_androidTheme {
        HomeScreen()
    }
}