package com.example.alkewallet_6.ui.wallet

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.alkewallet_6.R
import com.example.alkewallet_6.model.Transaction
import com.example.alkewallet_6.viewmodel.TransactionViewModel
import com.example.alkewallet_6.viewmodel.WalletViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.abs

class WalletActivity : AppCompatActivity() {

    private lateinit var tvSaldo: TextView
    private lateinit var etFrom: EditText
    private lateinit var etTo: EditText
    private lateinit var etMonto: EditText
    private lateinit var btnDepositar: Button
    private lateinit var btnRetirar: Button
    private lateinit var tvMovimientos: TextView

    private lateinit var walletViewModel: WalletViewModel
    private lateinit var transactionViewModel: TransactionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)

        tvSaldo = findViewById(R.id.tvSaldo)
        etFrom = findViewById(R.id.etFrom)
        etTo = findViewById(R.id.etTo)
        etMonto = findViewById(R.id.etMonto)
        btnDepositar = findViewById(R.id.btnDepositar)
        btnRetirar = findViewById(R.id.btnRetirar)
        tvMovimientos = findViewById(R.id.tvMovimientos)

        walletViewModel = ViewModelProvider(this)[WalletViewModel::class.java]
        transactionViewModel = ViewModelProvider(this)[TransactionViewModel::class.java]

        transactionViewModel.cargarTransactions()

        walletViewModel.saldo.observe(this) { saldoActual ->
            val formato = NumberFormat.getNumberInstance(Locale("es", "CL"))
            tvSaldo.text = "$${formato.format(saldoActual)}"
        }

        walletViewModel.mensaje.observe(this) { mensaje ->
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }

        transactionViewModel.transactions.observe(this) { lista ->
            if (lista.isEmpty()) {
                tvMovimientos.text = "Aún no hay movimientos"
            } else {
                val texto = StringBuilder()

                for (t in lista) {
                    val signo = if (t.amount >= 0) "+" else "-"
                    val montoFormateado = "$" + "%,.0f".format(abs(t.amount))

                    texto.append(
                        "📅 ${t.date}\n" +
                                "👤 ${t.from} ➡️ ${t.to}\n" +
                                "💸 ${t.description}: $signo$montoFormateado\n\n"
                    )
                }

                tvMovimientos.text = texto.toString()
            }
        }

        btnDepositar.setOnClickListener {
            val monto = etMonto.text.toString().toIntOrNull()
            val from = etFrom.text.toString().trim()
            val to = etTo.text.toString().trim()

            if (monto == null || monto <= 0 || from.isEmpty() || to.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos correctamente", Toast.LENGTH_SHORT).show()
            } else if (from == to) {
                Toast.makeText(this, "No puedes enviarte a ti mismo", Toast.LENGTH_SHORT).show()
            } else {
                walletViewModel.depositar(monto)

                val fecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
                transactionViewModel.addTransaction(
                    Transaction(
                        id = (1..100000).random().toString(),
                        date = fecha,
                        amount = monto.toDouble(),
                        description = "Depósito",
                        from = from,
                        to = to
                    )
                )

                etMonto.text.clear()
                etFrom.text.clear()
                etTo.text.clear()
            }
        }

        btnRetirar.setOnClickListener {
            val monto = etMonto.text.toString().toIntOrNull()
            val from = etFrom.text.toString().trim()
            val to = etTo.text.toString().trim()

            if (monto == null || monto <= 0 || from.isEmpty() || to.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos correctamente", Toast.LENGTH_SHORT).show()
            } else if (from == to) {
                Toast.makeText(this, "No puedes enviarte a ti mismo", Toast.LENGTH_SHORT).show()
            } else {
                val saldoAntes = walletViewModel.saldo.value ?: 0
                walletViewModel.retirar(monto)
                val saldoDespues = walletViewModel.saldo.value ?: 0

                if (saldoDespues < saldoAntes) {
                    val fecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
                    transactionViewModel.addTransaction(
                        Transaction(
                            id = (1..100000).random().toString(),
                            date = fecha,
                            amount = -monto.toDouble(),
                            description = "Retiro",
                            from = from,
                            to = to
                        )
                    )
                }

                etMonto.text.clear()
                etFrom.text.clear()
                etTo.text.clear()
            }
        }
    }
}