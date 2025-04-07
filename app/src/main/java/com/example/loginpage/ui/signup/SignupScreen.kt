package com.example.loginpage.ui.signup

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginpage.ui.components.HeaderText
import com.example.loginpage.ui.components.LoginTextField
import com.example.loginpage.ui.login.LoginScreen
import com.example.loginpage.ui.login.defaultPadding
import com.example.loginpage.ui.login.itemSpacing
import com.example.loginpage.ui.theme.LoginPageTheme

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    val (firstName, setFirstname) = rememberSaveable {
        mutableStateOf("")
    }
    val (lastName, setLastname) = rememberSaveable {
        mutableStateOf("")
    }
    val (email, setEmail) = rememberSaveable {
        mutableStateOf("")
    }
    val (password, setPassword) = rememberSaveable {
        mutableStateOf("")
    }
    val (confirmPassword, setConfirmPassword) = rememberSaveable {
        mutableStateOf("")
    }
    val (agree, onAgreeChange) = rememberSaveable {
        mutableStateOf(false)
    }

    val context = LocalContext.current
    Column (
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(defaultPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderText(
            text = "Sign Up",
            modifier = Modifier
                .padding(vertical = defaultPadding)
                .align(alignment = Alignment.Start)
        )
        LoginTextField(
            value = firstName,
            onValueChange = setFirstname,
            labelText = "First Name",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .height(defaultPadding)
        )
        LoginTextField(
            value = lastName,
            onValueChange = setLastname,
            labelText = "Last Name",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .height(defaultPadding)
        )
        LoginTextField(
            value = email,
            onValueChange = setEmail,
            labelText = "Email",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .height(defaultPadding)
        )
        LoginTextField(
            value = password,
            onValueChange = setPassword,
            labelText = "Password",
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier
                .fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(
            modifier = Modifier
                .height(defaultPadding)
        )
        LoginTextField(
            value = confirmPassword,
            onValueChange = setConfirmPassword,
            labelText = "Confirm Password",
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier
                .fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(
            modifier = Modifier
                .height(defaultPadding)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val privacyText = "Privacy"
            val policyText = "Policy"
            val annotatedString = buildAnnotatedString {
                withStyle(SpanStyle(color = MaterialTheme.colorScheme.onBackground)){
                    append("I agree with")
                }
                append(" ")
                withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)){
                    pushStringAnnotation(privacyText, privacyText)
                    append(privacyText)
                }
                append(" And ")
                withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)){
                    pushStringAnnotation(policyText, policyText)
                    append(policyText)
                }
                append(" ")

            }

            Checkbox(agree, onAgreeChange)

            ClickableText(annotatedString) {offset ->
                annotatedString.getStringAnnotations(offset, offset).forEach{
                    when(it.tag){
                        privacyText -> {
                            Toast.makeText(context, "Privacy Text Clicked", Toast.LENGTH_SHORT)
                                .show()
                        }
                        policyText -> {
                            Toast.makeText(context, "Policy Text Clicked", Toast.LENGTH_SHORT)
                                .show()
                        }

                    }
                }

            }

        }
        Spacer(
            modifier = Modifier
                .height(defaultPadding + 8.dp)
        )
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Signup")
        }
        Spacer(
            modifier = Modifier
                .height(defaultPadding)
        )
        val signInTxt = "Sign In"
        val signInAnnotation = buildAnnotatedString {
            withStyle(SpanStyle(color = MaterialTheme.colorScheme.onBackground)){
                append("Already have an account?")
            }
            append("  ")
            withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)){
                pushStringAnnotation(signInTxt, signInTxt)
                append(signInTxt)
            }
            append("  ")

        }
        ClickableText(signInAnnotation, ) {offset->
            signInAnnotation.getStringAnnotations(offset, offset).forEach{
                if (it.tag == signInTxt){
                    Toast.makeText(context, "Sign In Clicked", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun PreviewSignupScreen() {
    LoginPageTheme {
        SignUpScreen()
    }
}