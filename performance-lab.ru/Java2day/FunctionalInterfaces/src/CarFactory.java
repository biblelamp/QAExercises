public interface CarFactory<T extends Car> {
    public T create (String name);
}
