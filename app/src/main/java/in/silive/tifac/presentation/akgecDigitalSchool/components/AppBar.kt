package `in`.silive.tifac.presentation.akgecDigitalSchool.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.silive.tifac.R
import `in`.silive.tifac.presentation.Screen
import `in`.silive.tifac.presentation.ui.theme.BorderColor1
import `in`.silive.tifac.presentation.ui.theme.TextColor3
import `in`.silive.tifac.presentation.ui.theme.TextColor4
import `in`.silive.tifac.presentation.ui.theme.gilroy

@Composable
fun AppBar(selectedTabIndex: Int, onTabChanged: (Int) -> Unit = {}, navigateTo: (route: String) -> Unit = {}){
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(
                start = 24.dp,
                end = 24.dp,
                top = 16.dp,
                bottom = 12.dp
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.akgec_logo),
                contentDescription = stringResource(
                    R.string.akgec_logo
                ),
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
            )
            Text(
                text = stringResource(id = R.string.akgec_digital_school),
                fontSize = 14.sp,
                fontFamily = gilroy,
                fontWeight = FontWeight(700),
                color = TextColor3,
                modifier = Modifier
                    .padding(start = 8.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.ic_browser),
                contentDescription = stringResource(
                    R.string.akgec_skills
                ),
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .clickable {
                    navigateTo(Screen.SearchScreen.route)
                }
                .border(
                    width = 1.dp,
                    color = BorderColor1,
                    shape = RoundedCornerShape(size = 4.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start)
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = stringResource(
                    R.string.search
                ),
                modifier = Modifier
                    .height(16.dp)
                    .width(16.dp)
            )
            Text(
                text = stringResource(id = R.string.search),
                fontSize = 16.sp,
                fontFamily = gilroy,
                fontWeight = FontWeight(500),
                color = TextColor4,
                modifier = Modifier
                    .padding(end = 8.dp)
            )
        }
        Tabs(
            selectedTabIndex = selectedTabIndex
        ){
            onTabChanged(it)
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewAppBarNightMode() {
//    AppBar(selectedTabIndex = selectedTabIndex)
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewAppBar() {
//    AppBar(selectedTabIndex = selectedTabIndex)
}