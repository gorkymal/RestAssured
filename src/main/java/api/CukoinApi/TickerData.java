package api.CukoinApi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Comparator;

@FieldDefaults (level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties (ignoreUnknown = true)
@Getter
public class TickerData implements Comparator<TickerData> {

        String symbol;
        String symbolName;
        String buy;
        String sell;
        String changeRate;
        String changePrice;
        String high;
        String low;
        String vol;
        String volValue;
        String last;
        String averagePrice;
        String takerFeeRate;
        String makerFeeRate;
        String takerCoefficient;
        String makerCoefficient;


    @Override
    public int compare(TickerData o1, TickerData o2) {
        return o2.getBuy().compareTo(o1.getBuy());
    }
}
