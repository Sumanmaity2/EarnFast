package com.earnfast.earnfast.adapters;


        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.ProgressBar;
        import android.widget.TextView;

        import androidx.recyclerview.widget.RecyclerView;

        import com.bumptech.glide.Glide;
        import com.earnfast.earnfast.R;
        import com.earnfast.earnfast.models.QuestionModel;
        import com.google.android.material.progressindicator.CircularProgressIndicator;

        import java.util.ArrayList;
        import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ONE =1 ;
    private static final int TYPE_TWO = 2;
    private static final int TYPE_THREE = 3;
    private List<QuestionModel> itemList;
    private Context context;
    private ItemClickListener itemClickListener;
    // Constructor of the class
    public QuestionAdapter(List<QuestionModel> itemList,Context context) {
        this.itemList = itemList;
        this.context=context;
    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }
    public interface ItemClickListener  {
        void onItemClick(int position,boolean stat);
    }

    // determine which layout to use for the row
    @Override
    public int getItemViewType(int position) {
     QuestionModel questionModel=itemList.get(position);
        if (questionModel.getType() == 1) {
            return 1;
        } else if (questionModel.getType() == 2) {
            return 2;
        }
        else if (questionModel.getType() == 3) {
            return 3;
        }else {
            return -1;
        }
    }


    // specify the row layout file and click for each row
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ONE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class1, parent, false);
            return new ViewHolderOne(view);
        } else if (viewType == TYPE_TWO) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class2, parent, false);
            return new ViewHolderTwo(view);
        } else if (viewType == TYPE_THREE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class3, parent, false);
            return new ViewHolderThree(view);
        }
        else {
            throw new RuntimeException("The type has to be ONE or TWO");
        }
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int listPosition) {
        switch (holder.getItemViewType()) {
            case TYPE_ONE:
                initLayoutOne((ViewHolderOne)holder, listPosition);
                break;
            case TYPE_TWO:
                initLayoutTwo((ViewHolderTwo)holder, listPosition);
                break;
            case TYPE_THREE:
                initLayoutThree((ViewHolderThree)holder, listPosition);
                break;
            default:
                break;
        }
    }




    public void addItemClickListener(ItemClickListener listener){
        itemClickListener=listener;
  }
    private void initLayoutThree(ViewHolderThree holder, int listPosition) {
        holder.progressBar3.setProgress((listPosition)*10);
        holder.c3qno.setText(String.valueOf(listPosition+1));
        String question=itemList.get(listPosition).getQuestion();
        String[] arr=question.split("@",3);
        holder.tfquestion.setText(arr[0]);
        holder.c3qb.setText(arr[1]);
        holder.c3qc.setText(arr[2]);
        holder.tfa.setText(itemList.get(listPosition).getA());
        holder.tfb.setText(itemList.get(listPosition).getB());
        holder.tfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener!=null)
                    itemClickListener.onItemClick(listPosition,true);
                if (listPosition==itemList.size()-1){
                    holder.progressBar3.setProgress(100);
                }
            }
        });
        holder.tfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener!=null)
                    itemClickListener.onItemClick(listPosition,true);
                if (listPosition==itemList.size()-1){
                    holder.progressBar3.setProgress(100);
                }
            }
        });
    }

    private void initLayoutTwo(ViewHolderTwo holder, int listPosition) {
        holder.progressBar2.setProgress((listPosition)*10);
        holder.c2qno.setText(String.valueOf(listPosition+1));
        String question=itemList.get(listPosition).getQuestion();
        String[] arr=question.split("@",3);
        holder.iquestion.setText(arr[0]);
        holder.c2qb.setText(arr[1]);
        holder.c2qc.setText(arr[2]);
        Glide.with(context).load(itemList.get(listPosition
        ).getA()).into(holder.ioa);
        Glide.with(context).load(itemList.get(listPosition
        ).getB()).into(holder.iob);
        Glide.with(context).load(itemList.get(listPosition
        ).getC()).into(holder.ioc);
        Glide.with(context).load(itemList.get(listPosition
        ).getD()).into(holder.iod);
        holder.ioa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener!=null)
                    itemClickListener.onItemClick(listPosition,true);
                if (listPosition==itemList.size()-1){
                    holder.progressBar2.setProgress(100);
                }
            }
        });
        holder.iob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener!=null)
                    itemClickListener.onItemClick(listPosition,true);
                if (listPosition==itemList.size()-1){
                    holder.progressBar2.setProgress(100);
                }
            }
        });
        holder.ioc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener!=null)
                    itemClickListener.onItemClick(listPosition,true);
                if (listPosition==itemList.size()-1){
                    holder.progressBar2.setProgress(100);
                }
            }
        });
        holder.iod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener!=null)
                    itemClickListener.onItemClick(listPosition,true);
                if (listPosition==itemList.size()-1){
                    holder.progressBar2.setProgress(100);
                }
            }
        });

    }

    private void initLayoutOne(ViewHolderOne holder, int listPosition) {
        holder.progressBar1.setProgress((listPosition)*10);
        holder.c1qno.setText(String.valueOf(listPosition+1));
        String question=itemList.get(listPosition).getQuestion();
       String [] arr=question.split("@",3);
        holder.question.setText(arr[0]);
        holder.c1q2.setText(arr[1]);
        holder.c1q3.setText(arr[2]);
        holder.oa.setText(itemList.get(listPosition).getA());
        holder.ob.setText(itemList.get(listPosition).getB());
        holder.oc.setText(itemList.get(listPosition).getC());
        holder.od.setText(itemList.get(listPosition).getD());
        holder.oa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (itemClickListener!=null)
                    itemClickListener.onItemClick(listPosition,true);
                if (listPosition==itemList.size()-1){
                    holder.progressBar1.setProgress(100);
                }
            }
        });
        holder.ob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener!=null)
                    itemClickListener.onItemClick(listPosition,true);
                if (listPosition==itemList.size()-1){
                    holder.progressBar1.setProgress(100);
                }
            }
        });
        holder.oc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener!=null)
                    itemClickListener.onItemClick(listPosition,true);
                if (listPosition==itemList.size()-1){
                    holder.progressBar1.setProgress(100);
                }
            }
        });
        holder.od.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener!=null)
                    itemClickListener.onItemClick(listPosition,true);
                if (listPosition==itemList.size()-1){
                    holder.progressBar1.setProgress(100);
                }
            }
        });
    }



    // Static inner class to initialize the views of rows
    static class ViewHolderOne extends RecyclerView.ViewHolder {
        public TextView question,oa,ob,oc,od,c1q2,c1q3;
        public CircularProgressIndicator progressBar1;
        public TextView c1qno;

        public ViewHolderOne(View itemView) {
            super(itemView);
            question = (TextView) itemView.findViewById(R.id.c1q);
            oa = (TextView) itemView.findViewById(R.id.c1a);
            ob = (TextView) itemView.findViewById(R.id.c1b);
            oc = (TextView) itemView.findViewById(R.id.c1c);
            od = (TextView) itemView.findViewById(R.id.c1d);
            c1q2=itemView.findViewById(R.id.c1qb);
            c1q3=itemView.findViewById(R.id.c1qc);
            progressBar1=itemView.findViewById(R.id.c1p);
            c1qno=itemView.findViewById(R.id.c1qno);

        }
    }
    static class ViewHolderTwo extends RecyclerView.ViewHolder {
        public TextView iquestion,c2qb,c2qc;
        ImageView ioa,iob,ioc,iod;
        public CircularProgressIndicator progressBar2;
        public TextView c2qno;

        public ViewHolderTwo(View itemView) {
            super(itemView);
            iquestion = (TextView) itemView.findViewById(R.id.c2q);
            ioa = (ImageView) itemView.findViewById(R.id.c2aiv);
            iob = (ImageView) itemView.findViewById(R.id.c2biv);
            ioc = (ImageView) itemView.findViewById(R.id.c2civ);
            iod = (ImageView) itemView.findViewById(R.id.c2div);
            c2qb=itemView.findViewById(R.id.c2qb);
            c2qc=itemView.findViewById(R.id.c2qc);
            progressBar2=itemView.findViewById(R.id.c2p);
            c2qno=itemView.findViewById(R.id.c2qno);

        }
    }

    static class ViewHolderThree extends RecyclerView.ViewHolder {
        public TextView tfquestion,tfa,tfb,c3qb,c3qc;
        public CircularProgressIndicator progressBar3;
        public TextView c3qno;
        public ViewHolderThree(View itemView) {
            super(itemView);
            tfquestion=(TextView)itemView.findViewById(R.id.c3q);
            tfa = (TextView) itemView.findViewById(R.id.c3a);
            tfb = (TextView) itemView.findViewById(R.id.c3b);
            c3qb=itemView.findViewById(R.id.c3qb);
            c3qc=itemView.findViewById(R.id.c3qc);
            progressBar3=itemView.findViewById(R.id.c3p);
            c3qno=itemView.findViewById(R.id.c3qno);
        }
    }
}
