#version 300 es
precision lowp float;
uniform vec3 color;
out vec4 finalColor;

void main()
{
    finalColor = vec4(color, 1);
}
