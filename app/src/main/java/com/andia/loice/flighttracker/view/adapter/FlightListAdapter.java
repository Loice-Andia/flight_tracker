package com.andia.loice.flighttracker.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andia.loice.flighttracker.R;
import com.andia.loice.flighttracker.databinding.FlightViewBinding;
import com.andia.loice.flighttracker.model.data.FlightSchedule.Schedule;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class FlightListAdapter extends RecyclerView.Adapter<FlightListAdapter.ViewHolder> {

    private List<Schedule> scheduleResource;

    public FlightListAdapter(List<Schedule> scheduleResource) {
        this.scheduleResource = scheduleResource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flight_view, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Schedule schedule = scheduleResource.get(position);
        holder.binding.marketingCarrier.setText(schedule.getFlight().getMarketingCarrier().getAirlineID());
        holder.binding.operationCarrier.setText(String.format("Operated by {}",
                schedule.getFlight().getOperatingCarrier().getAirlineID()));
        holder.binding.deptTime.setText(schedule.getFlight().getDeparture().getScheduledTimeLocal().getDateTime());
        holder.binding.arrivalTime.setText(schedule.getFlight().getArrival().getScheduledTimeLocal().getDateTime());
        holder.binding.stops.setText(String.format("{} stops",
                schedule.getFlight().getDetails().getStops().getStopQuantity()));


    }

    @Override
    public int getItemCount() {
        return scheduleResource.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        View view;
        private FlightViewBinding binding;

        ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            binding = DataBindingUtil.bind(view);
        }
    }
}
