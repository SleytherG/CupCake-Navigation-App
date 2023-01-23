package com.example.cupcakeapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cupcakeapp.R
import com.example.cupcakeapp.ui.components.FormattedPriceLabel


/**
 * Composable thata displays the list of items as [RadioButton] options
 * [onSelectionChange] lambda that notifies the parent composable when a new value is selected
 * [onCancelButtonClicked] lambda that cancels the order when user clicks cancel and
 * [onNextButtonClicked] lambda that triggers the navigation to next screen
 */

@Composable
fun SelectOptionScreen(
 subtotal: String,
 options: List<String>,
 onSelectionChanged: (String) -> Unit = {},
 onCancelButtonClicked: () -> Unit = {},
 onNextButtonClicked: () -> Unit = {},
 modifier: Modifier = Modifier
) {
 var selectedValue by rememberSaveable { mutableStateOf("") }

 Column(
  modifier = Modifier.padding(16.dp)
 ) {
  options.forEach { item ->
   Row(
    modifier = Modifier.selectable(
     selected = selectedValue == item,
     onClick = {
      selectedValue = item;
      onSelectionChanged(item)
     }
    ),
    verticalAlignment = Alignment.CenterVertically
   ) {
    RadioButton(
     selected = selectedValue == item,
     onClick = {
      selectedValue = item;
      onSelectionChanged(item)
     }
    )
    Text(text = item)
   }
  }
  Divider(
   thickness = 1.dp,
   modifier = modifier.padding(bottom = 16.dp)
  )
  FormattedPriceLabel(
   subtotal = subtotal,
   modifier = Modifier
    .align(Alignment.End)
    .padding(top = 16.dp, bottom = 16.dp)
  )
  Row(
   modifier = Modifier.fillMaxWidth(),
   horizontalArrangement = Arrangement.spacedBy(16.dp)
  ) {
   OutlinedButton(
    onClick = onCancelButtonClicked ,
    modifier.weight(1f)
   ) {
    Text(text = stringResource(id = R.string.cancel))
   }
   Button(
    onClick = onNextButtonClicked,
    modifier = Modifier.weight(1f),
    enabled = selectedValue.isNotEmpty()
   ) {
    Text(text = stringResource(id = R.string.next))
   }
  }
 }
}

@Preview(showSystemUi = true)
@Composable
fun SelectOptionsPreview() {
 SelectOptionScreen(
  subtotal = "299.99",
  options = listOf("Option 1", "Option 2", "Option 3", "Option 4")
 )
}

