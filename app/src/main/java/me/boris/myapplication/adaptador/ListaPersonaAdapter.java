package me.boris.myapplication.adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import me.boris.myapplication.R;
import me.boris.myapplication.VerActivity;
import me.boris.myapplication.modelo.Persona;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListaPersonaAdapter extends RecyclerView.Adapter<ListaPersonaAdapter.PersonaViewHolder> {

    ArrayList<Persona> personaArrayList;
    ArrayList<Persona> personaArrayListOriginal;

    public ListaPersonaAdapter(ArrayList<Persona> personaArrayList) {
        this.personaArrayList = personaArrayList;
        personaArrayListOriginal = new ArrayList<>();
        personaArrayListOriginal.addAll(personaArrayList);
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_personas, null, false);
        return new PersonaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPersonaAdapter.PersonaViewHolder holder, int position) {
        holder.viewCedula.setText(personaArrayList.get(position).getCedula());
        holder.viewCiudadania.setText(personaArrayList.get(position).getCiudadania());
        holder.viewApellido.setText(personaArrayList.get(position).getApellido());
        holder.viewNombre.setText(personaArrayList.get(position).getNombre());
        holder.viewCiudad.setText(personaArrayList.get(position).getCiudad());
        holder.viewEstado.setText(personaArrayList.get(position).getEstado());
        holder.viewECivil.setText(personaArrayList.get(position).getEstadocivil());
        holder.viewSexo.setText(personaArrayList.get(position).getSexo());
    }

    @Override
    public int getItemCount() {
        return personaArrayList.size();
    }

    public class PersonaViewHolder extends RecyclerView.ViewHolder {

        TextView viewCedula, viewCiudadania, viewApellido, viewNombre, viewCiudad, viewEstado, viewECivil, viewSexo;

        public PersonaViewHolder(@NonNull View itemView) {
            super(itemView);
            viewCedula = itemView.findViewById(R.id.viewCedula);
            viewCiudadania = itemView.findViewById(R.id.viewCiudadania);
            viewApellido = itemView.findViewById(R.id.viewApellido);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewCiudad = itemView.findViewById(R.id.viewCiudad);
            viewEstado = itemView.findViewById(R.id.viewEstado);
            viewECivil = itemView.findViewById(R.id.viewECivil);
            viewSexo = itemView.findViewById(R.id.viewSexo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, VerActivity.class);
                    intent.putExtra("ID", personaArrayList.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}

/*extends RecyclerView.Adapter<ListaPersonaAdapter.PersonaViewHolder> {

    ArrayList<Persona> personaArrayList;

    public ListaPersonaAdapter(ArrayList<Persona> personaArrayList1)
    {
        this.personaArrayList =personaArrayList1;
    }


    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_personas,null,false);
        return new PersonaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        holder.viewID.setText(personaArrayList.get(position).getId());
        /*
        holder.viewNombre.setText(personaArrayList.get(position).getNombres());
        holder.viewCorreo.setText(personaArrayList.get(position).getCorreo());
    }

    @Override
    public int getItemCount() {
        return personaArrayList.size();
    }

    public class PersonaViewHolder extends RecyclerView.ViewHolder {

        TextView viewID, viewNombre,viewCorreo;

        public PersonaViewHolder(@NonNull View itemView) {
            super(itemView);

            /*viewID = itemView.findViewById(R.id.viewID);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewCorreo = itemView.findViewById(R.id.viewCorreo);

        }
    }
}*/
