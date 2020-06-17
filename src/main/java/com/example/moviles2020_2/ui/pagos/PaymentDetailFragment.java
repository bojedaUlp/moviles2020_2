package com.example.moviles2020_2.ui.pagos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviles2020_2.R;
import com.example.moviles2020_2.model.Pago;

import java.util.ArrayList;
import java.util.List;

public class PaymentDetailFragment extends Fragment {

    private PaymentViewModel mViewModel;
    List<Pago> listaMutable;
    RecyclerView contenedor;

    public static PaymentDetailFragment newInstance() {
        return new PaymentDetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.payment_detail_fragment, container, false);
        try {
            mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PaymentViewModel.class);
            contenedor = view.findViewById(R.id.rvPaymentDetail);

            RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext());
            contenedor.setLayoutManager(layout);

            mViewModel.obtenerPagos();

            listaMutable = new ArrayList<>();


            final Observer<List<Pago>> listObserver = new Observer<List<Pago>>() {
                @Override
                public void onChanged(List<Pago> pagos) {
                    contenedor.setAdapter(new AdapterPagosDetail(pagos));
                }
            };

            mViewModel.getPagos().observe(getViewLifecycleOwner(), listObserver);
        }catch (Exception e){
            Log.d("verPaymentDetail", e.getMessage());
        }

        return view;
    }


}
