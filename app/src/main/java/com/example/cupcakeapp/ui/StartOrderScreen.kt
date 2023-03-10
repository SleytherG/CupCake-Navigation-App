package com.example.cupcakeapp.ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cupcakeapp.R
import com.example.cupcakeapp.data.Datasource.quantityOptions


@Composable
fun StartOrdenScreen(
 quantityOptions: List<Pair<Int, Int>>,
 onNextButtonClicked: (Int) -> Unit,
 modifier: Modifier = Modifier
) {
 Column(
  modifier = Modifier
   .padding(16.dp)
   .fillMaxWidth(),
  horizontalAlignment = Alignment.CenterHorizontally,
  verticalArrangement = Arrangement.spacedBy(8.dp)
 ) {
  Spacer(modifier = Modifier.height(16.dp))
  Image(
   painter = painterResource(id = R.drawable.cupcake),
   contentDescription = null,
   modifier = Modifier.width(300.dp)
  )
  Spacer(modifier = Modifier.height(16.dp))
  Text(
   text = stringResource(id = R.string.order_cupcakes),
   style = MaterialTheme.typography.h4
  )
  Spacer(modifier = Modifier.height(8.dp))
  quantityOptions.forEach { item ->
   SelectQuantityButton(
    labelResourceId = item.first,
    onClick = { onNextButtonClicked(item.second) }
   )
  }
 }
}

@Composable
fun SelectQuantityButton(
 @StringRes labelResourceId: Int,
 onClick: () -> Unit,
 modifier: Modifier = Modifier
) {
 Button(
  onClick = onClick,
  modifier = modifier.widthIn(min = 250.dp)
 ) {
  Text(text = stringResource(id = labelResourceId))
 }
}

@Preview(showSystemUi = true)
@Composable
fun StartOrderPreview() {
 StartOrdenScreen(
  quantityOptions = quantityOptions,
  onNextButtonClicked = {}
 )
}