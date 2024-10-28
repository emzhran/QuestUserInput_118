package com.example.textfieldsss.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelpon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    var dataGender = listOf("Laki-Laki", "Perempuan")
    var konfirmNama by remember { mutableStateOf("") }
    var konfirmEmail by remember { mutableStateOf("") }
    var konfirmAlamat by remember { mutableStateOf("") }
    var konfirmNotelpon by remember { mutableStateOf("") }
    var konfirmGender by remember { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = {
                Text(text = "Nama")
            },
            placeholder = {
                Text(text = "Isi Nama Anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
        )
        Row (modifier = Modifier.fillMaxWidth()){
            dataGender.forEach{selectedGender->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = {gender = selectedGender}
                    )
                    Text(text = selectedGender)
                } }
        }
        TextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "Isi Email Anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = {
                Text(text = "Alamat")
            },
            placeholder = {
                Text(text = "Isi Alamat Anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
        )
        TextField(
            value = notelpon,
            onValueChange = { notelpon = it },
            label = {
                Text(text = "No Telpon")
            },
            placeholder = {
                Text(text = "Isi No Telpon Anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = {
            konfirmNama = nama
            konfirmEmail = email
            konfirmAlamat = alamat
            konfirmNotelpon = notelpon
            konfirmGender = gender
        }) {
            Text(text = "Simpan")
        }
        TampilData(
            param = "Nama",
            argu = konfirmNama)
        TampilData(
            param = "Email",
            argu = konfirmEmail)
        TampilData(
            param = "Alamat",
            argu = konfirmAlamat)
        TampilData(
            param = "No Telpon",
            argu = konfirmNotelpon)
        TampilData(
            param = "Gender",
            argu = konfirmGender)
    }
}
@Composable
fun TampilData(
    param: String, argu:String
){
    Column(
        modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = param, modifier = Modifier.weight(0.8f))
                Text(text = ": ", modifier = Modifier.weight(0.2f))
                Text(text = argu, modifier = Modifier.weight(2f))
            }
    }
}