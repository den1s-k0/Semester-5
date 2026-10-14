x = 0:0.1:10;
y = sin(x);

figure('Color','w');
plot(x, y, 'r--*', 'LineWidth', 1.5, 'MarkerSize', 6);
grid on;
xlabel('x', 'FontSize', 12);
ylabel('y = sin(x)', 'FontSize', 12);
title('График y = sin(x) на [0, 10]', 'FontSize', 14);

x = 0:0.1:10;
y1 = sin(x);
y2 = cos(x);
y3 = sin(x) .* cos(x);

figure('Color','w');
subplot(1,3,1);
plot(x, y1, 'b-', 'LineWidth', 1.5);
grid on; xlabel('x'); ylabel('y'); title('y = sin(x)');

subplot(1,3,2);
plot(x, y2, 'g-', 'LineWidth', 1.5);
grid on; xlabel('x'); ylabel('y'); title('y = cos(x)');

subplot(1,3,3);
plot(x, y3, 'm-', 'LineWidth', 1.5);
grid on; xlabel('x'); ylabel('y'); title('y = sin(x)*cos(x)');

figure('Color','w');
hold on;
plot(x, sin(x), 'b-', 'LineWidth', 1.5);
plot(x, cos(x), 'r--', 'LineWidth', 1.5);
hold off;
grid on; xlabel('x'); ylabel('y'); title('Несколько графиков');
legend('sin(x)', 'cos(x)');

x = -3:0.1:3;
y = -3:0.1:3;
[X, Y] = meshgrid(x, y);
Z = sin(X) .* cos(Y);

figure('Color','w');
surf(X, Y, Z);
xlabel('x'); ylabel('y'); zlabel('z');
title('Поверхность z = sin(x)*cos(y)');
colorbar;
shading interp;

figure('Color','w');
mesh(X, Y, Z);
xlabel('x'); ylabel('y'); zlabel('z');
title('Сетка поверхности z = sin(x)*cos(y)');

t = 0:0.05:10*pi;
x = cos(t);
y = sin(t);
z = t;

figure('Color','w');
plot3(x, y, z, 'b-', 'LineWidth', 1.5);
grid on;
xlabel('x'); ylabel('y'); zlabel('z');
title('Пространственная линия');

v = [5 -3 8 -1 0 7 -6 4 -2 9];
for i = 1:length(v)
    if v(i) < 0
        v(i) = 0;
    else
        v(i) = v(i)^2;
    end
end
disp('Вектор после обработки:');
disp(v);

M = [1 2 3; 4 5 6; 7 8 9];
S = 0;
[n, ~] = size(M);
for i = 1:n
    for j = 1:n
        if j > i
            S = S + M(i,j);
        end
    end
end
disp('Сумма элементов выше главной диагонали:');
disp(S);

N = 6;
f = 1;
for i = 1:N
    f = f * i;
end
disp('Факториал N:');
disp(f);

arr = randi([-20, 20], 1, 10);
sum_pos = 0;
count_neg = 0;
max_val = arr(1);
min_val = arr(1);
for i = 1:length(arr)
    if arr(i) > 0
        sum_pos = sum_pos + arr(i);
    elseif arr(i) < 0
        count_neg = count_neg + 1;
    end
    if arr(i) > max_val
        max_val = arr(i);
    end
    if arr(i) < min_val
        min_val = arr(i);
    end
end
disp('Массив:');
disp(arr);
disp('Сумма положительных:');
disp(sum_pos);
disp('Количество отрицательных:');
disp(count_neg);
disp('Максимум:');
disp(max_val);
disp('Минимум:');
disp(min_val);

C = 5;
arr2 = [3 -1 8 -4 7 2 -6 9 0 5];
sum_gt = 0;
for i = 1:length(arr2)
    if arr2(i) > C
        sum_gt = sum_gt + arr2(i);
    end
end
disp('Сумма элементов больше C:');
disp(sum_gt);

N = 4;
A = [1 2 3 4; 5 6 7 8; 9 10 11 12; 13 14 15 16];
for i = 1:N
    for j = 1:N
        if i == j
            A(i,j) = 0;
        end
    end
end
disp('Матрица с обнулённой главной диагональю:');
disp(A);

N = 4;
B = [1 2 3 4; 5 6 7 8; 9 10 11 12; 13 14 15 16];
for i = 1:N
    for j = 1:N
        if j <= i
            B(i,j) = 0;
        end
    end
end
disp('Матрица с обнулённой диагональю и ниже:');
disp(B);

arr3 = [4 -2 7 -5 0 3 -8 6 -1 9];
sum_p = 0;
cnt_n = 0;
for i = 1:length(arr3)
    if arr3(i) > 0
        sum_p = sum_p + arr3(i);
    elseif arr3(i) < 0
        cnt_n = cnt_n + 1;
    end
end
disp('Сумма положительных элементов:');
disp(sum_p);
disp('Количество отрицательных элементов:');
disp(cnt_n);