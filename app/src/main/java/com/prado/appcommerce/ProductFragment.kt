package com.prado.appcommerce

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prado.appcommerce.adapter.ProductAdapter
import com.prado.appcommerce.model.Product
import com.prado.appcommerce.model.ProductCategory

class ProductFragment : Fragment() {

    lateinit var recyclerProduct: RecyclerView
    lateinit var arrayProduct: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            arrayProduct = (arguments?.getSerializable("CATEGORY") as ProductCategory).products
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_product, container, false)

        recyclerProduct = view.findViewById(R.id.rv_product)

        val adapterProduct = ProductAdapter(arrayProduct, requireContext())

        recyclerProduct.adapter = adapterProduct
        recyclerProduct.layoutManager = GridLayoutManager(requireContext(), 3)

        return view
    }
}