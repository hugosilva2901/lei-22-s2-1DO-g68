package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Owner;
import pt.ipp.isep.dei.esoft.project.domain.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyRepository {
    List<Property> properties = new ArrayList<>();

    public PropertyRepository() {
        this.properties = new ArrayList<>();
    }

    public void add(Property property) {
        properties.add(property);
    }

    public Optional<Property> getByName(String name) {
        return properties.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
    }

    public List<Property> getAll() {
        return new ArrayList<>(properties);
    }

    public boolean remove(Property property) {
        return properties.remove(property);
    }
}
