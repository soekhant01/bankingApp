package com.example.bankingui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingui.data.Card
import com.example.bankingui.ui.theme.BlueEnd
import com.example.bankingui.ui.theme.BlueStart
import com.example.bankingui.ui.theme.GreenEnd
import com.example.bankingui.ui.theme.GreenStart
import com.example.bankingui.ui.theme.OrangeEnd
import com.example.bankingui.ui.theme.OrangeStart
import com.example.bankingui.ui.theme.PurpleEnd
import com.example.bankingui.ui.theme.PurpleStart

val cards= listOf(
    Card(
        cardType = "VISA",
        cardNumber = "3664 4665 5667 0859",
        cardName = "Business",
        balance = 120.664,
        color = getGradient(PurpleStart, PurpleEnd),
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "1357 2652 7408 9512",
        cardName = "Savings",
        balance = 12.65,
        color = getGradient(BlueStart, BlueEnd),
    ),
    Card(
        cardType = "VISA",
        cardNumber = "3216 5498 7530 0159",
        cardName = "School",
        balance = 5.577,
        color = getGradient(OrangeStart, OrangeEnd),
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "9545 6842 1203 9902",
        cardName = "Trips",
        balance = 60.444,
        color = getGradient(GreenStart, GreenEnd),
    )
)

fun getGradient(
    startColor: Color,
    endColor: Color,
) : Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Composable
fun CardsSection(){
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
     index: Int
){
    val card= cards[index]
    var lastItemPaddingEnd= 0.dp
    if(index == cards.size -1) lastItemPaddingEnd= 16.dp
    var image= painterResource(id= R.drawable.ic_visa)
    if(card.cardType == "MASTER CARD") image= painterResource(id= R.drawable.ic_mastercard)

    Box(
        modifier= Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {  }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier
                    .width(60.dp)
            )
            Text(
                text= card.cardType,
                color= Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text= "$ ${card.balance}",
                color= Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text= card.cardNumber,
                color= Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}