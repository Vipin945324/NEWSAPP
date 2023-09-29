package digi.coders.newsapp.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import digi.coders.newsapp.Fragment.BusinessFragment;
import digi.coders.newsapp.Fragment.EntertainmentFragment;
import digi.coders.newsapp.Fragment.GeneralFragment;
import digi.coders.newsapp.Fragment.HealthFragment;
import digi.coders.newsapp.Fragment.HomeFragment;
import digi.coders.newsapp.Fragment.ScienceFragment;
import digi.coders.newsapp.Fragment.TechnologyFragment;
import digi.coders.newsapp.Fragment.SportsFragment;

public class TabAdapter extends FragmentPagerAdapter {
    public TabAdapter(@NonNull FragmentManager fm) {
        super(fm);

    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position==0)
        {
            return new HomeFragment();
        }
        else if (position==1)
        {
            return  new BusinessFragment();
        }
        else if(position==2)
        {
            return new EntertainmentFragment();
        }
        else if(position==3)
        {
            return new GeneralFragment();
        }

        else if(position==4)
        {
            return new HealthFragment();
        }

        else if(position==5)
        {
            return new ScienceFragment();
        }
        else if(position==6)
        {
            return new SportsFragment();
        }
        else if(position==7)
        {
            return new TechnologyFragment();
        }
        return new TechnologyFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position==0)
        {
            return "Home";
        }
        else if (position==1)
        {
            return "Business";
        }
        else if(position==2)
        {
            return "Entertainment";
        }
        else if(position==3)
        {
            return "General";
        }

        else if(position==4)
        {
            return "Health";
        }
        else if(position==5)
        {
            return "science";
        }
        else if(position==6)
        {
            return "sports";
        }
        else if(position==7)
        {
            return "Technology";
        }



        return "Technology";
    }

    @Override
    public int getCount() {
        return 8;
    }
}

