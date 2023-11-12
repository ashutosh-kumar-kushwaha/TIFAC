package `in`.silive.tifac.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.silive.tifac.R
import `in`.silive.tifac.presentation.Screen
import `in`.silive.tifac.presentation.ui.theme.BGColor1
import `in`.silive.tifac.presentation.ui.theme.BtnColor1
import `in`.silive.tifac.presentation.ui.theme.TextColor1
import `in`.silive.tifac.presentation.ui.theme.TextColor2

@Composable
fun OnboardingScreen(navigateTo: (route: String) -> Unit) {
    Column(
        modifier = Modifier
            .background(BGColor1)
            .padding(top = 221.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.akgec_skills_logo),
            contentDescription = "AKGEC Skills Logo",
            modifier = Modifier
                .padding(horizontal = 84.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(49.dp))
        Button(
            onClick = {
                navigateTo(Screen.AkgecDigitalSchoolScreen.route)
            },
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = BtnColor1,
                contentColor = Color.White
            ),
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .heightIn(min = 45.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.akgec_digital_school),
                fontFamily = FontFamily(Font(R.font.gilroy)),
                fontWeight = W500,
                textAlign = TextAlign.Center,
                letterSpacing = 0.27.sp,
                fontSize = 18.sp,
                color = Color.White,
            )
        }
        Spacer(modifier = Modifier.height(28.dp))
        Button(
            onClick = {
                navigateTo(Screen.AkgecSkillsScreen.route)
            },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = TextColor1
            ),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_browser),
                contentDescription = "Browser",
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(id = R.string.go_to_akgecskills_in),
                fontFamily = FontFamily(Font(R.font.gilroy)),
                fontWeight = W600,
                color = Color(0xFF163971),
                letterSpacing = 1.sp,
                fontSize = 20.sp
            )
        }
        Text(
            text = stringResource(id = R.string.based_on_accumulated_research_expertise_in_system_biology_with_the_vision_of_helping_understand_life_mechanism_better),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.gilroy)),
            fontWeight = FontWeight(500),
            color = TextColor2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 44.dp)
                .padding(top = 131.dp),
            lineHeight = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    OnboardingScreen{

    }
}