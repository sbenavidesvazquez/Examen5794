package com.example.samsung.examen5794;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.samsung.examen5794.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.details);
            //instanciamos el boton del fragment
            Button limpiar= (Button) rootView.findViewById(R.id.bLimpiar);
            //Al boton instanciamos un onclicklistener, e implementa el método por defecto onClick
            limpiar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Aqui metemos el metodo creado
                    Limpieza();
                }
            });

        }

        return rootView;
    }
    //Se crea el metodo para borrar el textView del fragment
    public void Limpieza(){
        //Instanciamos un textView, y lo unimos con el del detail.
        TextView tx= (TextView) getView().findViewById(R.id.item_detail);
        //Hacemos que sobrescriba lo escrito, pero esta vez no escribirá nada
        tx.setText(" ");
    }
}
